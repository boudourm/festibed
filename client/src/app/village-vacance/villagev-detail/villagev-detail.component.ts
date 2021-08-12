import { Component, OnInit ,AfterViewInit, ViewChild, ElementRef} from '@angular/core';
import { NgxSpinnerService } from "ngx-spinner";
import { hebergement} from 'app/interfaces/hebergement';
import { Villagevacance} from 'app/interfaces/villagevacance';
import { Location } from '@angular/common';
import { HebergementService } from 'app/services/hebergementService/hebergement.service';
import {ActivatedRoute} from '@angular/router';
//import { MapsAPILoader, MouseEvent } from '@agm/core';





@Component({
  selector: 'app-villagev-detail',
  templateUrl: './villagev-detail.component.html',
  styleUrls: ['./villagev-detail.component.scss']
})

export class VillagevDetailComponent implements OnInit {

  @ViewChild('mapContainer', {static: false}) gmap: ElementRef;

vv : Villagevacance = null;
Image: string[]=['https://images.unsplash.com/photo-1539600937385-bd902dd379cc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80','https://images.unsplash.com/photo-1539600937385-bd902dd379cc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80','https://images.unsplash.com/photo-1539600937385-bd902dd379cc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80'];

lat: number = 51.678418;
lng: number = 7.809007;


constructor(private SpinnerService: NgxSpinnerService,private location: Location, private route : ActivatedRoute,private VillageVacanceServ : HebergementService) { }
async ngOnInit() {
  this.SpinnerService.show(); 
  const id= this.route.snapshot.params['id'];
  this.vv=this.VillageVacanceServ.getVillageVacanceById(id);
  this.SpinnerService.hide(); 

}
public back() {
  this.location.back();
}


}
