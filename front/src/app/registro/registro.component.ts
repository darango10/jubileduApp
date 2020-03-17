import {Component, OnInit} from '@angular/core';
import {Cliente} from '../clientes/cliente';
import {ClienteService} from '../clientes/cliente.service';
import {ActivatedRoute, Router} from '@angular/router';
import swal from 'sweetalert2';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {
  titulo = 'Sign Up';
  cliente: Cliente = new Cliente();
  formRegistro: any;

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
    this.clienteService.create(this.cliente).subscribe(cliente => {
        this.router.navigate(['/clientes']);
        swal.fire('Usuario Registrado', `${cliente.nombre} registrado con exito`, 'success');
      }
    );
  }
}
