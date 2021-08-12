import { Component, OnInit } from '@angular/core';
import { ClientInterface } from 'app/interfaces/ClientInterface';
import { Location } from '@angular/common';
import { MatSnackBar } from '@angular/material';
import { NgxSpinnerService } from "ngx-spinner";
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {ClientService} from 'app/services/ClientService/client-service.service';
import { AuthService } from 'app/services/Authservice/auth.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-ajouter-hebergement',
  templateUrl: './ajouter-hebergement.component.html',
  styleUrls: ['./ajouter-hebergement.component.scss']
})
export class AjouterHebergementComponent implements OnInit {
  favoriteSeason: string;
  seasons: string[] = ['Hotel', 'Camping', 'Residence', 'Village Vacance'];

  isLoading : boolean = true; 
  clientModifier : ClientInterface;
  estClient :boolean;
  estHebergeur:boolean;
  estOrganisateur:boolean;
  client:ClientInterface;
  espace: FormGroup;
  

  constructor( private router : Router,private snackBar: MatSnackBar, private location: Location,private SpinnerService: NgxSpinnerService,
    private formBuilder: FormBuilder , private clientServ : ClientService, private authserv : AuthService) {
    }

    
 async  ngOnInit(){
  this.SpinnerService.show(); 
  this.client= new ClientInterface("","","");
  
  await this.clientServ.getSingleBook();
  this.isLoading = false;   
  this.SpinnerService.hide();



this.espace = this.formBuilder.group({
NomCommercial: ['', Validators.required],
SiteWeb:['', Validators.required],
state: ['', Validators.required]

});
}


  
 
        
   }

   