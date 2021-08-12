import { Component, OnInit } from '@angular/core';
import { NgxSpinnerService } from "ngx-spinner";
import { hebergement} from 'app/interfaces/hebergement';
import { Hotel} from 'app/interfaces/Hotel';
import { Location } from '@angular/common';
import { HebergementService } from 'app/services/hebergementService/hebergement.service';

@Component({
  selector: 'app-hotel',
  templateUrl: './hotel.component.html',
  styleUrls: ['./hotel.component.scss']
})
export class HotelComponent implements OnInit {
  
 hotel : Hotel[];
 actualPage:number=1;
  constructor(private hotelServ : HebergementService,private SpinnerService: NgxSpinnerService,private location: Location) { }

  async ngOnInit() {
    this.SpinnerService.show();
    await this.hotelServ.getHotels().then(
      (hots:Hotel[])=>{
        this.hotel=hots;
      }
    );
    this.SpinnerService.hide();
  }
  public back() {
    this.location.back();
  }


}

