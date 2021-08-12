import { Component, OnInit,AfterViewInit, ViewChild, ElementRef  } from '@angular/core';
//import {} from '@types/googlemaps';
import { Location } from '@angular/common';
import {ActivatedRoute} from '@angular/router';
import { festival } from 'app/interfaces/festival';
import { FestivalServiceService } from 'app/services/festivalService/festival-service.service';
import { NgxSpinnerService } from "ngx-spinner";
import {placesFestival} from 'app/interfaces/placesFestival';
import { PanierService } from 'app/services/PanierService/panier.service';
import { panierFestival } from 'app/interfaces/panier/panierFestival';
import {MatSnackBar} from '@angular/material';
@Component({
  selector: 'app-festival-detail',
  templateUrl: './festival-detail.component.html',
  styleUrls: ['./festival-detail.component.scss']
})
export class FestivalDetailComponent implements OnInit,AfterViewInit {
  @ViewChild('mapContainer', {static: false}) gmap: ElementRef;
  map: google.maps.Map;
  lat = 40.730610;
  lng = -73.935242;
  coordinates = new google.maps.LatLng(this.lat, this.lng);
  mapOptions: google.maps.MapOptions = {
    center: this.coordinates,
    zoom: 8
   };
   marker = new google.maps.Marker({
    position: this.coordinates,
    map: this.map,
  });
  festival: festival={
    codePostal:0,
    commune:"",
    coordonnees:"",
    dateDebut:"",
    dateFin:"",
    id:"",
    nbPlaceTotal:0,
    nom:"",
    siteWeb:""
  };
  places:placesFestival[]=[];
  cat0:boolean;
  cat1:boolean;
  cat2:boolean;
  constructor(private SpinnerService: NgxSpinnerService,private location: Location, private route : ActivatedRoute,
    private festiServ :FestivalServiceService,private panierServ :PanierService,private snackBar: MatSnackBar ) { }


  async ngOnInit() {
    const id= this.route.snapshot.params['id'];
    this.SpinnerService.show();
   await this.festiServ.getFestivalByID(""+id+"").then(
     (fest: festival)=>{
       console.log(fest.nom);
      this.festival=fest;
     }
   );
   this.places= await this.festiServ.getFestivalPLaces(""+id+"");
   this.verifyCat();
    this.SpinnerService.hide();
  }
  public back() {
    this.location.back();
  }
categorie(i :number):boolean{
  return this.places[i].num===1;
}
verifyCat(){
  for (let index = 0; index < this.places.length; index++) {
    if(this.places[index].num==0){
      this.cat0=this.places[index].places!=[];
      console.log(this.cat0);
    }else if(this.places[index].num==1){
      this.cat1=this.places[index].places!=[];
      console.log(this.cat1);
    }
  }
}
iscat1(i:number):boolean{
  return this.places[i].num==1;
}
ajoutPlaceFestival(idPlac:number,prixF:number,date:string,iP:number){
  const nbP=+(<HTMLInputElement>document.getElementById("quant"+idPlac)).value;
  console.log(iP<nbP);
  if(iP<nbP){
    this.snackBar.open('Vous avez ajouter plus de places que prévues', 'OK', {
      duration: 3000,
      panelClass: ['info-snackbar']
  });
  }else{
  let festiv:panierFestival={
    idF:this.route.snapshot.params['id'],
    idP:idPlac,
    nbPlaces:+(<HTMLInputElement>document.getElementById("quant"+idPlac)).value,
    nomF:this.festival.nom,
    prix:prixF,
    date:date
  };
  this.panierServ.addF(festiv);
  //this.places[iF].places[iP].nbPlaces--;
  console.log(this.panierServ.getPanier());
}
}
supprimerPlaceFestival(i :number){
  this.panierServ.removeF(i);
  console.log(this.panierServ.getPanier());
}/*
getPlaces(i:number):number{
  return this
}*/



    ngAfterViewInit() {
    this.mapInitializer();
  }
   mapInitializer() {
     this.map = new google.maps.Map(this.gmap.nativeElement,
     this.mapOptions);
     this.marker.setMap(this.map);
   }


}
