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
  selector: 'app-espace-client',
  templateUrl: './espace-client.component.html',
  styleUrls: ['./espace-client.component.scss']
})
export class EspaceClientComponent implements OnInit {
  isLoading : boolean = true; 
  clientModifier : ClientInterface;
  estClient :boolean;
  estHeber:boolean;
  estOrg:boolean;
  client:ClientInterface;
  espace: FormGroup;
  constructor( private router : Router,private snackBar: MatSnackBar, private location: Location,private SpinnerService: NgxSpinnerService,
    private formBuilder: FormBuilder , private clientServ : ClientService, private authserv : AuthService) {
      
  }

 async ngOnInit() {
  this.SpinnerService.show(); 
  this.client= new ClientInterface("","","");
  await this.clientServ.getSingleBook().then(
    (client: ClientInterface)=>{
      console.log(client);
      this.client=client;
      console.log(this.client);
    }
  );
   this.init();    
 }

 public init(){
  //getdata

      this.isLoading = false; 
      console.log(this.client.state);
      if(this.client.state=="Client"){
        console.log(this.client.state);
        this.estClient=true;
      }else if(this.client.state=="Hébergeur"){
        this.estHeber=true;
      }else{
        this.estOrg=true;
      }
      
      this.SpinnerService.hide();
 
  
  this.espace = this.formBuilder.group({
    nom: ['', Validators.required],
    prenom:['', Validators.required],
    state: ['', Validators.required]
  });
  console.log(this.client);
 }

 //retour à la page précedente
 public back() {
   this.location.back();
 }

 //modification des données de l'user
 modifier(){
  let nom = this.espace.get('nom').value;
  let prenom = this.espace.get('prenom').value;
  if(prenom ==""){
    prenom =this.client.secondName;
  }
  if(nom==""){
    nom=this.client.name;
  }
  const client = new ClientInterface(nom,prenom,this.client.state);
   this.clientServ.Modifier(client);
   //this.router.navigate(['/Home']);
 }

 //fonction de récuperation du nom de la photo et visualisation
 modifierStatus(status : string){
  const client = new ClientInterface(this.client.name,this.client.secondName,status);
  this.clientServ.Modifier(client);
  // this.router.navigate(['/Home']);
 }

}
