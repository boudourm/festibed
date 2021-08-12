import {MediaMatcher} from '@angular/cdk/layout';
import {ChangeDetectorRef, Component, OnDestroy,OnInit} from '@angular/core';
import {enableProdMode} from '@angular/core';
import { AuthService } from './services/Authservice/auth.service';
import { PanierService } from './services/PanierService/panier.service';
import { Router } from '@angular/router';
import 'bootstrap/dist/js/bootstrap.bundle';
import { NgxSpinnerService } from 'ngx-spinner';
import {ClientService} from 'app/services/ClientService/client-service.service';
import { ClientInterface } from 'app/interfaces/ClientInterface';
import {MatSnackBar} from '@angular/material';
import {panier} from 'app/interfaces/panier/panier';



enableProdMode();
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent  implements OnDestroy,OnInit{
  mobileQuery: MediaQueryList;
  private _mobileQueryListener: () => void;
  client:ClientInterface= new ClientInterface("","","");
  monPanier:panier={
    festivals:[],herbergs:[],total:0
  };
  estClient:boolean;
  estOrg:boolean;
  estHeber:boolean;
  constructor(changeDetectorRef: ChangeDetectorRef, media: MediaMatcher, private snackBar: MatSnackBar,
    private route : Router,public authService: AuthService,private spinner: NgxSpinnerService,
    private panier: PanierService,private clientServ : ClientService) {


    console.log(this.authService.isLogin);
    this.mobileQuery = media.matchMedia('(min-width: 100px)');
    this._mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addListener(this._mobileQueryListener);
}
public ngOnDestroy(): void {
  this.mobileQuery.removeListener(this._mobileQueryListener);

}

  public logout() {
    this.authService.signOut().then(res => {
      sessionStorage.clear();
      this.route.navigate(['/Home']);
      this.snackBar.open('Vous êtes maintenant déconnecté(e)', 'OK', {
          duration: 3000,
          panelClass: ['info-snackbar']
      });

  }, err => {
      this.snackBar.open(err, 'OK', {
          duration: 3000,
          panelClass: ['error-snackbar']
      });

  });

}
showSpinner() {
  this.spinner.show();
  setTimeout(() => {
      /** spinner ends after 5 seconds */
      this.spinner.hide();
  }, 5000);
}

private openFlyout: boolean = false;
getPanier(){
  this.monPanier=this.panier.getPanier();
  this.openFlyout = !this.openFlyout;
}
async ngOnInit() {
  this.spinner.hide();
  await this.clientServ.getSingleBook().then(
    (client: ClientInterface)=>{
      console.log(client);
      this.client=client;
      console.log(this.client);
    }
  );
  if(this.client.state=="Client"){
    this.estClient=true;
  }else if(this.client.state=="Hébergeur"){
    this.estHeber=true;
  }else{
    this.estOrg=true;
  }
  //this.showSpinner();
}
}
