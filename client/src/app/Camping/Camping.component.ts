import { Component, OnInit } from '@angular/core';
import { NgxSpinnerService } from "ngx-spinner";
import { hebergement} from 'app/interfaces/hebergement';
import { Camping} from 'app/interfaces/camping';
import { Location } from '@angular/common';
import { HebergementService } from 'app/services/hebergementService/hebergement.service';




@Component({
  selector: 'app-Camping',
  templateUrl: './Camping.component.html',
  styleUrls: ['./Camping.component.scss']
})
export class CampingComponent implements OnInit {
  campings:Camping[]=[];
  constructor(private SpinnerService: NgxSpinnerService,private location: Location, private hebergServ:HebergementService) {

   }

  async ngOnInit() {
    this.SpinnerService.show();
      await this.hebergServ.getCampings().then(
        (camp:Camping[])=>{
          this.campings=camp;
        }
      );
      this.SpinnerService.hide();
  }



    public back() {
      this.location.back();
    }



}
