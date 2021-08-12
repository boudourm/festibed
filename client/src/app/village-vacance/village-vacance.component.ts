import { Component, OnInit } from '@angular/core';
import { NgxSpinnerService } from "ngx-spinner";
import { hebergement} from 'app/interfaces/hebergement';
import { Villagevacance} from 'app/interfaces/villagevacance';
import { Location } from '@angular/common';
import { HebergementService } from 'app/services/hebergementService/hebergement.service';

@Component({
  selector: 'app-village-vacance',
  templateUrl: './village-vacance.component.html',
  styleUrls: ['./village-vacance.component.scss']
})
export class VillageVacanceComponent implements OnInit {
  
  villageVacance : Villagevacance[];
  actualPage:number=1;
  constructor(private VillageVacanceServ : HebergementService,private SpinnerService: NgxSpinnerService,private location: Location) { }

  async ngOnInit() {
    this.SpinnerService.show();
    await this.VillageVacanceServ.getVillagVac().then(
      (vilvac:Villagevacance[])=>{
        this.villageVacance=vilvac;
      }
    );
    this.SpinnerService.hide();
  }
  public back() {
    this.location.back();
  }


}




