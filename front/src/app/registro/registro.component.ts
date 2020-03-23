import {Component, OnInit} from '@angular/core';
import {Cliente} from '../clientes/cliente';
import {ClienteService} from '../clientes/cliente.service';
import {ActivatedRoute, Router} from '@angular/router';
import swal from 'sweetalert2';
import {Usuario} from '../usuarios/usuario';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {
  titulo = 'Sign Up';
  cliente: Cliente = new Cliente();
  usuario: Usuario = new Usuario();
  formRegistro: any;
  private errores: string[];

  constructor(private clienteService: ClienteService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.cargarCliente();
  }

  cargarCliente(): void {
    this.activatedRoute.params.subscribe(params => {
      const id = params.id;
      if (id) {
        this.clienteService.getCliente(id).subscribe(cliente => this.cliente = cliente
        );
      }
    });
  }

  create() {
    this.clienteService.create(this.cliente).subscribe(json => {
        this.router.navigate(['']);
        swal.fire('Usuario Registrado', `${json.cliente.nombre} registrado con exito`, 'success');
      },
      err => {
        this.errores = err.error.errors as string[];
      }
    );
  }
  createUser() {
    this.clienteService.createUser(this.usuario).subscribe(json => {
          // this.router.navigate(['']);
          // swal.fire('Usuario Registrado', `${json.cliente.nombre} registrado con exito`, 'success');
        },
        err => {
          this.errores = err.error.errors as string[];
        }
    );
  }


  update() {
    this.clienteService.update(this.cliente).subscribe(
      json => {
        this.router.navigate(['/clientes']);
        swal.fire('Usuario Actualizado', `${json.cliente.nombre} actualizado con exito`, 'success');
      },
      err => {
        this.errores = err.error.errors as string[];
      }
    );
  }
}
