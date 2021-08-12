import { Component, OnInit,Input } from '@angular/core';
import { panierFestival } from 'app/interfaces/panier/panierFestival';
import { panierHeber } from 'app/interfaces/panier/panierHeber';
import { AuthService } from '../services/Authservice/auth.service';
import { PanierService } from 'app/services/PanierService/panier.service';
@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.scss']
})
export class PanierComponent implements OnInit {
  @Input() listFest : panierFestival[]=[] ;
  @Input() listHeb : panierHeber[]=[] ;
  @Input() total : number;

  constructor(private authServ: AuthService,private panierServ :PanierService) { }

  ngOnInit() {
    console.log(this.authServ.isLogin);
    console.log(this.listFest);
    this.panierEstVide();
    console.log(this.panierEstVide());
  }
  panierEstVide():boolean{
    return this.listFest.length==0 && this.listHeb.length==0;
  }
  supprimerPlaceFestival(idP:number){
    this.panierServ.removeF(idP);
  }
}
