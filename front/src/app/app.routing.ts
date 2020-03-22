// Importar modulos del router
import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

// Importar Componentes
import {IndexComponent} from './index/index.component';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {LoginComponent} from './usuarios/login.component';
import {RegistroComponent} from './registro/registro.component';
import {CalculadoraComponent} from './calculadora/calculadora.component';
import {ClientesComponent} from './clientes/clientes.component';
import {AuthGuard} from './usuarios/guards/auth.guard';
import {ClienteService} from './clientes/cliente.service';
import {AuthService} from './usuarios/auth.service';
import {RoleGuard} from './usuarios/guards/role.guard';

// Array de Rutas
const appRoutes: Routes = [
  {path: '', component: IndexComponent},
  {path: 'login', component: LoginComponent},
  {path: 'registro', component: RegistroComponent},
  {path: 'calculadora', component: CalculadoraComponent},
  {path: 'clientes', component: ClientesComponent, canActivate: [AuthGuard, RoleGuard], data: {role: 'ROLE_ADMIN'}},
  {path: 'clientes/registro/:id', component: RegistroComponent, canActivate: [AuthGuard, RoleGuard], data: {role: 'ROLE_ADMIN'}}
];

// Exportar el modulo del router
export const appRoutingProviders: any[] = [];
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
