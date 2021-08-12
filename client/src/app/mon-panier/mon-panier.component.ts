import { Component, OnInit } from '@angular/core';
import {panier} from 'app/interfaces/panier/panier';
import { PanierService } from '../services/PanierService/panier.service';
import { Location } from '@angular/common';
import * as html2pdf from 'html2pdf.js';
import * as jsPDF from 'jspdf';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-mon-panier',
  templateUrl: './mon-panier.component.html',
  styleUrls: ['./mon-panier.component.scss']
})
export class MonPanierComponent implements OnInit {
  monPanier:panier={
    festivals:[],
  herbergs:[],
  total:0
  };
  constructor(private panierServ :PanierService,private location: Location,private snackBar: MatSnackBar) { }

  async ngOnInit() {
   
    this.monPanier= this.panierServ.getPanier();
    this. estVide();
    console.log(this.monPanier.festivals);
    console.log(this.estVide());
  
  }
  public back() {
    this.location.back();
  }
  estVide():boolean{
    if(this.monPanier.festivals.length==0 && this.monPanier.herbergs.length===0){
      return true;
    }
    return false;
  }
  supprimerPlaceFestival(idP:number){
    this.panierServ.removeF(idP);
  }
  dPDF(){

    const options ={
        filename:'FestiBed_Facture.pdf',
        image:{type:'jpg'},
        html2canvas:{},
        jsPDF:{orientation:'landscape'}
    };
    const content  = document.getElementById('element-to-export');
  /*  html2pdf()
        .from(content)
        .set(options)
        .save();*/
        if(this.panierServ.validerPanier()){
          var pdf = new jsPDF();
        pdf.text('papapap',180,10);
        pdf.fromHTML(content,100,15);
        pdf.save('FestiBed.pdf');
        this.snackBar.open('Votre réservation est enregistrée', 'OK', {
          duration: 3000,
          panelClass: ['info-snackbar']
      });
        }else{
          this.snackBar.open('Veuillez ajouter au moins un festival , hebergement ainsi qu un hebergement adéquat au nombre de places de festival', 'OK', {
            duration: 7000,
            panelClass: ['info-snackbar']
        });

        }
        
}


}
