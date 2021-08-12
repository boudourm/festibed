import { Component, OnInit } from '@angular/core';
import { NgxSpinnerService } from "ngx-spinner";
import { FormulaireService } from 'app/services/formulaireService/formulaire.service';
import { departements } from 'app/interfaces/departements';
import { domaines } from 'app/interfaces/domaines';
import { regions } from 'app/interfaces/regions';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { festival } from 'app/interfaces/festival';
import * as moment from 'moment';
import { FestivalServiceService } from 'app/services/festivalService/festival-service.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})


export class HomeComponent implements OnInit {
  festivals: festival[]=[];
  afficherFest:boolean=false;
  afficherHeb:boolean=false;
  states: departements[] = [];
  regions: regions[]=[];
  domaines : domaines[]=[];
  festivalForm: FormGroup;
  hebergForm: FormGroup;
  startDate: string = moment().format();
  endDate: string = moment().format();
  selected: {startDate , endDate };
  typeHeber: string[]=["Hôtel" , "Résidence","Village Vacance","Camping"];
  constructor(private SpinnerService: NgxSpinnerService , private formServ : FormulaireService,
    private formBuilder: FormBuilder,private festServ: FestivalServiceService ) { }

  ngOnInit() {
    this.SpinnerService.show();
    this.formServ.getDepartements().then(
      (depart:departements[])=>{
        this.states=depart;
        console.log(this.states);
      }
    );
      this.formServ.getDomaines().then(
        (dom:domaines[])=>{
          this.domaines=dom;
        }
      );
      this.formServ.getRegions().then(
        (reg:regions[])=>{
          this.regions=reg;
        }
      );
        this.SpinnerService.hide();
        this.festivalForm = this.formBuilder.group({
          nomF: ['', Validators.required],
          prix:['', Validators.required],
          date: ['', Validators.required],
          dep: ['', Validators.required],
          reg:['', Validators.required],
          dom: ['', Validators.required]
        });
        this.hebergForm = this.formBuilder.group({
          nomH: ['', Validators.required],
          prixH:['', Validators.required],
          dateH: ['', Validators.required],
          depH: ['', Validators.required],
          regH:['', Validators.required],
          typeHeb: ['', Validators.required]
        });
        
    
  }
async validerFest(){
  let nomF =this.festivalForm.get('nomF').value;
  let prix =this.festivalForm.get('prix').value;
  let date =this.festivalForm.get('date').value;
  let dep =this.festivalForm.get('dep').value;
  let reg =this.festivalForm.get('reg').value;
  let dom =this.festivalForm.get('dom').value;
  let dateD:string;
  let dateF:string;
  console.log(date);
  if(nomF==null){
    nomF="";
  }
  if(prix==null){
    prix="";
  }
  if(date.start!=null){
    dateD=""+date.start.format('DD-MM-YYYY');
  }else{
    dateD="2020-02-17";
  }
  if(date.end!=null){
    dateF=""+date.end.format('DD-MM-YYYY');
  }else{
    dateF="";
  }
  
  if(dep==null){
    dep="";
  }
  if(dom==null){
    dom="";
  }
  if(nomF==null){
    nomF="";
  }
  console.log(nomF+""+dateD+""+dateF+""+prix+""+dom+""+dep+""+reg);
  this.SpinnerService.show();
  /*await this.festServ.getRechercheFest(dateD,dateF,nomF,dep,dom,reg,""+prix).then(
    (fest:festival[])=>{
      this.festivals=fest;
    }
  );*/
  this.SpinnerService.hide();
  this.afficherFest=true;
  this.afficherHeb=false;

}
validerHeberg(){
  const nomH =this.hebergForm.get('nomH').value;
  const prixH =this.hebergForm.get('prixH').value;
  const dateH =this.hebergForm.get('dateH').value;
  const depH =this.hebergForm.get('depH').value;
  const regH =this.hebergForm.get('regH').value;
  const typeHeb =this.hebergForm.get('typeHeb').value;
  if(dateH!=null){
    console.log(""+dateH.start.format('DD/MM/YYYY'));
  }else{
    console.log("null");
  }

  
  console.log(typeHeb);
  console.log(nomH);
  console.log(prixH);
}

}
