import {Component, OnInit} from '@angular/core';
import {Cliente} from '../clientes/cliente';
import {ClienteService} from '../clientes/cliente.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {
  titulo = 'Sign Up';
  cliente: Cliente = new Cliente();
  formRegistro: any;

  constructor(private clienteService: ClienteService, private router: Router) {
  }

  ngOnInit(): void {
  }

  create() {
    this.clienteService.create(this.cliente).subscribe(
      response => this.router.navigate(['/clientes']));
    console.log(this.cliente);
  }
}
