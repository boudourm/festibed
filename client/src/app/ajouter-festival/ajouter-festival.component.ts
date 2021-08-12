import { Component, OnInit } from '@angular/core';
import { ClientInterface } from 'app/interfaces/ClientInterface';
import { festival } from 'app/interfaces/festival';
import { Location } from '@angular/common';
import { MatSnackBar } from '@angular/material';
import { NgxSpinnerService } from "ngx-spinner";
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {ClientService} from 'app/services/ClientService/client-service.service';
import { AuthService } from 'app/services/Authservice/auth.service';
import { Router } from '@angular/router';
import { departements } from 'app/interfaces/departements';
import { domaines } from 'app/interfaces/domaines';
import { regions } from 'app/interfaces/regions';
import {FormulaireService} from 'app/services/formulaireService/formulaire.service';

@Component({
  selector: 'app-ajouter-festival',
  templateUrl: './ajouter-festival.component.html',
  styleUrls: ['./ajouter-festival.component.scss']
})
export class AjouterFestivalComponent implements OnInit {
  isLoading : boolean = true; 
  FestivForm: FormGroup;
  Dom: domaines[]=[];
  Dep: departements[]=[];
  reg: regions[]=[];

  

  
  constructor( private router : Router,private snackBar: MatSnackBar, private location: Location,private SpinnerService: NgxSpinnerService,
    private formBuilder: FormBuilder , private clientServ : ClientService, private authserv : AuthService,private FormServ :FormulaireService) {
   
 
    }

  ngOnInit() {
    this.SpinnerService.show(); 
    this.initForm();
    
  }
  public back() {
    this.location.back();
  }


 async initForm() {
    this.FestivForm = this.formBuilder.group({
      nom: ['',[Validators.required]],
      site:['',[Validators.required]],
      prixcat1:['',[Validators.required]],
      NbPlaceCat1 : ['',[Validators.required]],
      prixcat2: '',
      NbPlaceCat2: '',
      adresse: ['',[Validators.required]],
      dateDebut: ['',[Validators.required]],
      dateFin: ['',[Validators.required]],
     
     
      departement: ['',[Validators.required]],
      Domaine: ['',[Validators.required]],
      region: ['',[Validators.required]]
      
    });
    await this.FormServ.getDepartements().then(
      (dept:departements[])=>{
        this.Dep=dept;
      }
    );
    await this.FormServ.getDomaines().then(
      (domain:domaines[])=>{
        this.Dom=domain;
      }
    );

    await this.FormServ.getRegions().then(
      (region:regions[])=>{
        this.reg=region;
      }
    );

  }

    addFestival(){
 
        const nom =this.FestivForm.get('nom').value;
        const site =this.FestivForm.get('site').value;
        const prixcat1 =this.FestivForm.get('prixcat1').value;
        const NbPlaceCat1 =this.FestivForm.get('NbPlaceCat1').value;
        const prixcat2 =this.FestivForm.get('prixcat2').value;
        const adresse =this.FestivForm.get('adresse').value;
        const dateDebut =this.FestivForm.get('dateDebut').value;
        const dateFin =this.FestivForm.get('dateFin').value;
        const  departement =this.FestivForm.get('departement').value;
        const  Domaine  =this.FestivForm.get('Domaine').value;
        const  region =this.FestivForm.get('region').value;
        const  CompDomaine =this.FestivForm.get('ComplementDomaine').value;
        const CodePostal =this.FestivForm.get('CodePostal').value;
        const  Commune =this.FestivForm.get('Commune').value;
      
       
        console.log(nom);
        console.log(dateDebut);
      }
    }
    //getDepartements()
    //getRegions()
    //getRegions()
     
    
