import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MatTabsModule} from '@angular/material/tabs';
import {  ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import {MatIconModule} from '@angular/material/icon';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatMenuModule} from '@angular/material/menu';
import {MatListModule} from '@angular/material/list';
import {MatToolbarModule} from '@angular/material/toolbar';

import {AppRoutingModule} from './app-routing.module';
import { HomeComponent } from './home/home.component';
import {FestivalsComponent} from './festivals/festivals.component';
import { AuthComponent } from './auth/auth.component';
import { EspaceClientComponent } from './espace-client/espace-client.component';
import { PanierComponent } from './panier/panier.component';
import { NotFoundComponent } from './not-found/not-found.component';
import {MatSelectModule} from '@angular/material/select';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatCardModule} from '@angular/material/card';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatFormFieldModule, MatInputModule, MatNativeDateModule } from '@angular/material';
import {MatSliderModule} from '@angular/material/slider';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import {DataViewModule} from 'primeng/dataview';


import {AuthService} from './services/Authservice/auth.service';
import {ClientService} from './services/ClientService/client-service.service';
import {FestivalServiceService} from './services/festivalService/festival-service.service';
import {HebergementService} from './services/hebergementService/hebergement.service';
import {FormulaireService} from './services/formulaireService/formulaire.service';
import {AuthGuardService} from './services/authGuard/auth-guard.service';
import { AngularFireAuth } from 'angularfire2/auth';
import { AngularFireModule } from '@angular/fire';
import { environment } from '../environments/environment';
import { AngularFirestoreModule } from '@angular/fire/firestore';
import { AngularFireStorageModule } from '@angular/fire/storage';
import { AngularFireAuthModule } from '@angular/fire/auth';
import {HttpClientModule} from '@angular/common/http';
import { NgxSpinnerModule } from "ngx-spinner";
import {NgxPaginationModule} from 'ngx-pagination';
import { FlyoutModule } from 'ngx-flyout';
import { NgxDaterangepickerMd } from 'ngx-daterangepicker-material';
import { FestivalDetailComponent } from './festivals/festival-detail/festival-detail.component';
import { FooterComponent } from './footer/footer.component';
import { CampingComponent} from './Camping/Camping.component';
import { HotelComponent } from './hotel/hotel.component';
import { VillageVacanceComponent } from './village-vacance/village-vacance.component';
import { ResidenceComponent } from './residence/residence.component';
import { VillagevDetailComponent } from './village-vacance/villagev-detail/villagev-detail.component';
import { AjouterFestivalComponent } from './ajouter-festival/ajouter-festival.component';
import { AjouterHebergementComponent } from './ajouter-hebergement/ajouter-hebergement.component';
import {MatBadgeModule} from '@angular/material/badge';
import {MatRadioModule} from '@angular/material/radio';
import {AgmCoreModule} from '@agm/core';
import { MonPanierComponent } from './mon-panier/mon-panier.component';
import {PanelModule} from 'primeng/panel';
import { DetailCampingComponent } from './camping/detail-camping/detail-camping.component';
import { FestivalListeComponent } from './festivals/festival-liste/festival-liste.component';


@NgModule({
  declarations: [
    PanierComponent,
    NotFoundComponent,
    EspaceClientComponent,
    AuthComponent,
    HomeComponent,
    FestivalsComponent,
    AppComponent,
    FestivalDetailComponent,
    FooterComponent,
    CampingComponent,
    HotelComponent,
    VillageVacanceComponent,
    ResidenceComponent,
    VillagevDetailComponent,
    AjouterFestivalComponent,
    AjouterHebergementComponent,
    MonPanierComponent,
    DetailCampingComponent,
    FestivalListeComponent
  ],



  imports: [
    PanelModule,
    MDBBootstrapModule,
    BrowserAnimationsModule,
    MatSelectModule,
    AppRoutingModule,
    BrowserModule,
    DataViewModule,
    FormsModule,
    ReactiveFormsModule,
    MatIconModule,
    MatSnackBarModule,
    MatBadgeModule,
    MatMenuModule,
    MatListModule,
    MatToolbarModule,
    MatTabsModule,
    MatCardModule,
    MatDatepickerModule,
    MatFormFieldModule,
     MatInputModule, 
    MatNativeDateModule,
    MatSliderModule,
    MatFormFieldModule,
    MatInputModule,
    HttpClientModule,
    MatCardModule,
    AngularFireModule.initializeApp(environment.firebase),
    AngularFirestoreModule, // imports firebase/firestore, only needed for database features
    AngularFireAuthModule, // imports firebase/auth, only needed for auth features,
    AngularFireStorageModule, // imports firebase/storage only needed for storage features
    NgxSpinnerModule,
    NgxPaginationModule,
    FlyoutModule,
    NgxDaterangepickerMd.forRoot(),
    BrowserModule,
    FormsModule,
    MatIconModule,
    MatRadioModule,
    BrowserModule,
    AgmCoreModule.forRoot({
      apiKey :'AIzaSyDzFo8nsE4c2TGtUaLC_VtTX9rArHmVNmg'
    })


  ],

  providers: [AuthGuardService,AuthService,ClientService,HebergementService,FestivalServiceService,FormulaireService],
  bootstrap: [AppComponent]
})
export class AppModule { }
