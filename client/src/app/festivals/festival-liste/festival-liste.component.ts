import { Component, OnInit,Input } from '@angular/core';
import { festival } from 'app/interfaces/festival';

@Component({
  selector: 'app-festival-liste',
  templateUrl: './festival-liste.component.html',
  styleUrls: ['./festival-liste.component.scss']
})


export class FestivalListeComponent implements OnInit {
  @Input() festivals :festival[];
  estVide:boolean=false;
  constructor() { }

  ngOnInit() {
    this.estVide=(this.festivals.length==0);
    console.log(this.estVide);
  }

}
