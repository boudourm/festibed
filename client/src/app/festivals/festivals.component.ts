import { Component, OnInit,AfterViewInit, ViewChild, ElementRef  } from '@angular/core';

import { FestivalServiceService } from 'app/services/festivalService/festival-service.service';
import { festival } from 'app/interfaces/festival';
import { Location } from '@angular/common';
import { NgxSpinnerService } from "ngx-spinner";
@Component({
  selector: 'app-festivals',
  templateUrl: './festivals.component.html',
  styleUrls: ['./festivals.component.scss']
})
export class FestivalsComponent implements OnInit {
  @ViewChild('mapContainer', {static: false}) gmap: ElementRef;
  map: google.maps.Map;
  lat = 40.730610;
  lng = -73.935242;
  festivals: festival[];
  actualPage:number=1;
  constructor(private festiServ : FestivalServiceService,private SpinnerService: NgxSpinnerService,private location: Location) { }
  coordinates = new google.maps.LatLng(this.lat, this.lng);
  mapOptions: google.maps.MapOptions = {
    center: this.coordinates,
    zoom: 8
   };
   marker = new google.maps.Marker({
    position: this.coordinates,
    map: this.map,
  });

  

 
  async ngOnInit() {
    this.SpinnerService.show(); 
    await this.festiServ.getFestivals().then(
      (fest:festival[])=>{
        this.festivals=fest;
      }
    );
    this.SpinnerService.hide();
  }
  public back() {
    this.location.back();
  }
  isItnullDD(i : number):boolean{
    return this.festivals[i].dateDebut=="null";
  }
  isItnullDF(i : number):boolean{
    return this.festivals[i].dateFin=="null";
  }

}
