import { Component, OnInit } from '@angular/core';
import { NgxSpinnerService } from "ngx-spinner";
import { hebergement} from 'app/interfaces/hebergement';
import { Residence} from 'app/interfaces/residence';
import { Location } from '@angular/common';
import { HebergementService } from 'app/services/hebergementService/hebergement.service';

@Component({
  selector: 'app-residence',
  templateUrl: './residence.component.html',
  styleUrls: ['./residence.component.scss']
})
export class ResidenceComponent implements OnInit {
  
residence : Residence[];
  constructor(private residenceServ : HebergementService,private SpinnerService: NgxSpinnerService,private location: Location) { }

  async ngOnInit() {
    this.SpinnerService.show();
  await this.residenceServ.getResidences().then(
    (res:Residence[])=>{
      this.residence=res;
    }
  );
  this.SpinnerService.hide();
  }
  public back() {
    this.location.back();
  }


}
