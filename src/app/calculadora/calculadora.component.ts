import {Component, OnInit} from '@angular/core';
import {Cotizante} from './cotizante';

@Component({
  selector: 'app-calculadora',
  templateUrl: './calculadora.component.html',
  styleUrls: ['./calculadora.component.css']
})
export class CalculadoraComponent implements OnInit {
  public cotizante: Cotizante;
  public anios: number;
  public tiempo: number;
  public mostrarPrimaMedia = false;
  public mostrarAhorroIndividual = false;

  constructor() {
    this.cotizante = new Cotizante('', '', null, '', null, null);
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.cotizante);
    if (this.cotizante.genero === 'H') {
      this.anios = 62 - this.cotizante.edad;
    } else {
      this.anios = 57 - this.cotizante.edad;
    }

    this.tiempo = 1300 - this.cotizante.semanas;
  }

  mostrarResultado() {
    if (this.cotizante.regimen === 'PM') {
      this.mostrarPrimaMedia = true;
      this.mostrarAhorroIndividual = false;
    } else {
      this.mostrarPrimaMedia = false;
      this.mostrarAhorroIndividual = true;
    }
  }

  ocultarResultado() {
    this.mostrarPrimaMedia = false;
    this.mostrarAhorroIndividual = false;
  }
}
