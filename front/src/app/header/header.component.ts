import {Component, OnInit} from '@angular/core';
import {AuthService} from '../usuarios/auth.service';
import swal from 'sweetalert2';
import {Router} from '@angular/router';
import {ClienteService} from '../clientes/cliente.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public authService: AuthService,
              public router: Router,
              public clienteService: ClienteService) {
  }

  ngOnInit(): void {
  }

  logout() {
    let username = this.authService.usuario.username;
    this.authService.logout();
    swal.fire('Logout', `${username}, has cerrado sesion`, 'success');
    this.router.navigate(['/']);
  }
}
