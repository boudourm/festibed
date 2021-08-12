import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AuthComponent } from './auth/auth.component';
import { EspaceClientComponent } from './espace-client/espace-client.component';
import { PanierComponent } from './panier/panier.component';
import { MonPanierComponent } from './mon-panier/mon-panier.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { FestivalsComponent } from './festivals/festivals.component';
import { FestivalDetailComponent } from './festivals/festival-detail/festival-detail.component';
import { CampingComponent } from './Camping/Camping.component';
import { HotelComponent } from './hotel/hotel.component';
import { VillageVacanceComponent } from './village-vacance/village-vacance.component';
import { ResidenceComponent } from './residence/residence.component';
import { VillagevDetailComponent } from './village-vacance/villagev-detail/villagev-detail.component';
import { AjouterFestivalComponent } from './ajouter-festival/ajouter-festival.component';
import { AjouterHebergementComponent } from './ajouter-hebergement/ajouter-hebergement.component';
import{ DetailCampingComponent} from './camping/detail-camping/detail-camping.component';
import{ DetailResidenceComponent} from './residence/detail-residence/detail-residence.component';
import {AuthGuardService} from './services/authGuard/auth-guard.service';
const appRoutes : Routes =[
    {path: 'Login' , component: AuthComponent},
    {path: 'EspaceClient' , canActivate:[AuthGuardService],component: EspaceClientComponent},
    {path: 'Panier' , component: MonPanierComponent},
    {path: 'Festivals' , component: FestivalsComponent},
    {path:'Festivals/:id',component:FestivalDetailComponent},
    {path: 'Home' , component: HomeComponent},
    {path: '', redirectTo: 'Home', pathMatch: 'full'},
    {path: 'Camping', component: CampingComponent},
    {path: 'hotel', component: HotelComponent},
    {path: 'village-vacance', component: VillageVacanceComponent},
    {path: 'village-vacance/:id', component: VillagevDetailComponent},
    {path: 'ajouter-festival',canActivate:[AuthGuardService], component: AjouterFestivalComponent},
    {path: 'ajouter-hebergement',canActivate:[AuthGuardService], component: AjouterHebergementComponent},
    {path: 'residence', component: ResidenceComponent},
    {path: 'residence/:id', component: ResidenceComponent},
   
    {path: 'Camping/:id', component: DetailCampingComponent},
    {path: 'not-found', component: NotFoundComponent},
    {path: '**', redirectTo: 'not-found'}

];
@NgModule({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}