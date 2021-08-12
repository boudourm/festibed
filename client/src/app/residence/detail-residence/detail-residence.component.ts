import { Component, OnInit ,AfterViewInit, ViewChild, ElementRef} from '@angular/core';
import { NgxSpinnerService } from "ngx-spinner";
import { hebergement} from 'app/interfaces/hebergement';
import { Residence} from 'app/interfaces/residence';
import { Location } from '@angular/common';
import { HebergementService } from 'app/services/hebergementService/hebergement.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-detail-residence',
  templateUrl: './detail-residence.component.html',
  styleUrls: ['./detail-residence.component.scss']
})
export class DetailResidenceComponent implements OnInit {



res : Residence = null;
Image: string[]=['https://images.unsplash.com/photo-1539600937385-bd902dd379cc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80','https://images.unsplash.com/photo-1539600937385-bd902dd379cc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80','https://images.unsplash.com/photo-1539600937385-bd902dd379cc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80'];

lat: number = 51.678418;
lng: number = 7.809007;


constructor(private SpinnerService: NgxSpinnerService,private location: Location, private route : ActivatedRoute,private ResidenceServ : HebergementService) { }
async ngOnInit() {
  this.SpinnerService.show(); 
  const id= this.route.snapshot.params['id'];
  this.res=this.ResidenceServ.getResidenceById(id);
  this.SpinnerService.hide(); 

}
public back() {
  this.location.back();
}


}
