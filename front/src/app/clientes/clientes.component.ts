import {Component, OnInit} from '@angular/core';
import {Cliente} from './cliente';
import {CLIENTES} from './clientes.json';
import {ClienteService} from './cliente.service';
import Swal from 'sweetalert2';
import {FilterUtils} from 'primeng/utils';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  clientes: Cliente[];
  cols: any[];
  dt: any;
  id: number;


  constructor(private clienteService: ClienteService) {
  }

  ngOnInit(): void {
    this.clienteService.getClientes().subscribe(
      clientes => this.clientes = clientes
    );

    this.cols = [
      {field: 'cedula', header: 'Cedula'},
      {field: 'nombre', header: 'Nombre'},
      {field: 'apellido', header: 'Apellido'},
      {field: 'email', header: 'Email'},
      {field: 'password', header: 'Password'},
      {field: 'fecha', header: 'Fecha'},
      {field: 'telefono', header: 'Telefono'},
      {field: 'genero', header: 'Genero'},
      {field: 'semanas', header: 'Semanas'},
      {field: 'salario', header: 'Salario'}
    ];

    FilterUtils['custom'] = (value, filter): boolean => {
      if (filter === undefined || filter === null || filter.trim() === '') {
        return true;
      }

      if (value === undefined || value === null) {
        return false;
      }

      return parseInt(filter) > value;
    };
  }

  delete(cliente: Cliente): void {
    Swal.fire({
      title: 'Estas seguro?',
      text: `Seguro deseas eliminar a ${cliente.nombre} ${cliente.apellido}`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar!'
    }).then((result) => {
      if (result.value) {
        this.clienteService.delete(cliente.id).subscribe(
          response => {
            this.clientes = this.clientes.filter(cli => cli !== cliente);
            Swal.fire(
              'Cliente Eliminado!',
              `${cliente.nombre} ha sido eliminado`,
              'success'
            );
          }
        );

      }
    });
  }

}
