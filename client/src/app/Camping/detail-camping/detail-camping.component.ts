import { Component, OnInit ,AfterViewInit, ViewChild, ElementRef} from '@angular/core';
import { NgxSpinnerService } from "ngx-spinner";
import { hebergement} from 'app/interfaces/hebergement';
import { Camping } from 'app/interfaces/camping';
import { Location } from '@angular/common';
import { HebergementService } from 'app/services/hebergementService/hebergement.service';
import {ActivatedRoute} from '@angular/router';
//import { MapsAPILoader, MouseEvent } from '@agm/core';


@Component({
  selector: 'app-detail-camping',
  templateUrl: './detail-camping.component.html',
  styleUrls: ['./detail-camping.component.scss']
})
export class DetailCampingComponent implements OnInit {
  camp : Camping = {
    Heb:{
      idHeb:0,
    dateClassement:"",
    datePublication:"",
    Typologie:"",
    Classement:0,
    Categorie:"",
    Mention:"",
    Telephone:"",
    Courrierl:"",
    SiteInternet:"",
    CapaciteAcceuil:0,
    Coordonnes:"",
    Note:0,
    Description:"",
    NomCommercial:"",
    Adresse:"",
    CodePostal:"",
    Commune: ""
    },
    TarifEmplacement:""
  };
  Image: string[]=['https://images.unsplash.com/photo-1539600937385-bd902dd379cc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80','https://images.unsplash.com/photo-1539600937385-bd902dd379cc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80','https://images.unsplash.com/photo-1539600937385-bd902dd379cc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80'];

constructor(private SpinnerService: NgxSpinnerService,private location: Location, private route : ActivatedRoute,private CampingServ : HebergementService) { }
async ngOnInit() {
  this.SpinnerService.show(); 
  const id= this.route.snapshot.params['id'];
  await this.CampingServ.getCampingById(+id).then(
    (cmp:Camping)=>{
      console.log(cmp);
      this.camp=cmp;
    }
  );

  console.log(this.camp);
  this.SpinnerService.hide(); 
  

}

public back() {
  this.location.back();
}

}
