import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {routing, appRoutingProviders} from './app.routing';

import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {IndexComponent} from './index/index.component';
import {FooterComponent} from './footer/footer.component';
import {LoginComponent} from './usuarios/login.component';
import {RegistroComponent} from './registro/registro.component';
import {CalculadoraComponent} from './calculadora/calculadora.component';
import {FormsModule} from '@angular/forms';
import {ClientesComponent} from './clientes/clientes.component';
import {HttpClientModule} from '@angular/common/http';
import {TableModule} from 'primeng/table';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    IndexComponent,
    FooterComponent,
    LoginComponent,
    RegistroComponent,
    CalculadoraComponent,
    ClientesComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    routing,
    FormsModule,
    TableModule
  ],
  providers: [appRoutingProviders],
  bootstrap: [AppComponent]
})
export class AppModule {
}
