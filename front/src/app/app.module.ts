import {BrowserModule} from '@angular/platform-browser';
import {LOCALE_ID, NgModule} from '@angular/core';
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
import {registerLocaleData} from '@angular/common';
import localeES from '@angular/common/locales/es';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatMomentDateModule} from '@angular/material-moment-adapter';

registerLocaleData(localeES, 'es');

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
    TableModule,
    BrowserAnimationsModule,
    MatDatepickerModule,
    MatMomentDateModule
  ],
  providers: [appRoutingProviders,
    {provide: LOCALE_ID, useValue: 'es'}],
  bootstrap: [AppComponent]
})
export class AppModule {
}
