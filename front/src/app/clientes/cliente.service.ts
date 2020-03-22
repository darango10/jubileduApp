import {Injectable} from '@angular/core';
import {CLIENTES} from './clientes.json';
import {Cliente} from './cliente';
import {Observable, of, throwError} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {catchError} from 'rxjs/operators';
import Swal from 'sweetalert2';
import {Router} from '@angular/router';
import {AuthService} from '../usuarios/auth.service';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private urlEndpoint = 'http://localhost:8080/api/clientes';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});


  constructor(private http: HttpClient,
              private router: Router,
              private authService: AuthService) {
  }

  private agregarAuthorizationHeader() {
    let token = this.authService.token;
    if (token != null) {
      return this.httpHeaders.append('Authorization', 'Bearer ' + token);
    }
    return this.httpHeaders;
  }

  private isNoAutorizado(e): boolean {
    if (e.status === 401) {
      if (this.authService.isAuthenticated()) {
        this.authService.logout();
      }

      this.router.navigate(['/login']);
      return true;
    }
    if (e.status === 403) {
      Swal.fire('Acceso Denegado', `Hola ${this.authService.usuario.username}, no tienes acceso a este recurso`, 'warning');
      this.router.navigate(['']);
      return true;
    }
    return false;
  }


  getClientes(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.urlEndpoint, {headers: this.agregarAuthorizationHeader()});
  }

  create(cliente: Cliente): Observable<any> {
    return this.http.post<any>(this.urlEndpoint, cliente, {headers: this.httpHeaders}).pipe(
      catchError(e => {
        if (e.status === 400) {
          return throwError(e);
        }


        console.log(e.error.mensaje);
        Swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  getCliente(id): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.urlEndpoint}/registro/${id}`, {headers: this.agregarAuthorizationHeader()}).pipe(
      catchError(e => {

        console.log(e.error.mensaje);
        Swal.fire('Error al editar', 'Debes estar autenticado', 'error');
        if (this.isNoAutorizado(e)) {
          return throwError(e);
        }

        if (e.status === 400) {
          return throwError(e);
        }
      })
    );
  }

  update(cliente: Cliente): Observable<any> {
    return this.http.put<any>(`${this.urlEndpoint}/registro/${cliente.id}`, cliente, {headers: this.agregarAuthorizationHeader()}).pipe(
      catchError(e => {

        console.log(e.error.mensaje);
        Swal.fire(e.error.mensaje, 'Debes estar autenticado', 'error');
        if (this.isNoAutorizado(e)) {
          return throwError(e);
        }

        if (e.status === 400) {
          return throwError(e);
        }
      })
    );
  }

  delete(id: number): Observable<Cliente> {
    return this.http.delete<Cliente>(`${this.urlEndpoint}/${id}`, {headers: this.agregarAuthorizationHeader()}).pipe(
      catchError(e => {

        console.log(e.error.mensaje);
        Swal.fire(e.error.mensaje, 'Debes estar autenticado', 'error');

        if (this.isNoAutorizado(e)) {
          return throwError(e);
        }

        if (e.status === 400) {
          return throwError(e);
        }
      })
    );
  }
}
