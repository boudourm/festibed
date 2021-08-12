import { Injectable } from '@angular/core';
import { panierFestival } from 'app/interfaces/panier/panierFestival';
import { panierHeber } from 'app/interfaces/panier/panierHeber';
import { panier } from 'app/interfaces/panier/panier';
import {MatSnackBar} from '@angular/material';
@Injectable({
  providedIn: 'root'
})
export class PanierService {
  festvalsList:panierFestival[]=[];
  hebergementsList:panierHeber[]=[];
  indexPlace:number=0;
  indexHeb:number=0;
  constructor(private snackBar: MatSnackBar) { }
  
  addF(festival :panierFestival){
    if(this.placeExist(festival.idP)){
      this.festvalsList[this.indexPlace].nbPlaces+=festival.nbPlaces;
      this.festvalsList[this.indexPlace].prix=this.festvalsList[this.indexPlace].prix*this.festvalsList[this.indexPlace].nbPlaces;
      this.snackBar.open('Vous avez résrver '+festival.nbPlaces+' places', 'OK', {
        duration: 3000,
        panelClass: ['info-snackbar']
    });
    }else{     
    let f : panierFestival = {
      "idF" :festival.idF,
      "nomF" : festival.nomF,
      "idP" : festival.idP,
      "nbPlaces":festival.nbPlaces,
      "prix" : festival.prix*festival.nbPlaces,
      "date":festival.date
    };
   this.festvalsList.push(f);
   this.snackBar.open('Vous avez résrver '+festival.nbPlaces+' places', 'OK', {
    duration: 3000,
    panelClass: ['info-snackbar']
});
  }
  }
  placeExist(idP:number):boolean{
    for (let index = 0; index < this.festvalsList.length; index++) {
      if(this.festvalsList[index].idP===idP) {
        this.indexPlace=index;
        return true;
      }     
    }
    return false;
  }
  removeF(index : number) {
    if(this.placeExist(index)){
        this.festvalsList.splice(this.indexPlace,1);
        this.snackBar.open('Vous avez supprimer un festival de votre panier ', 'OK', {
          duration: 3000,
          panelClass: ['info-snackbar']
      });
      this.getTotal();
      
    }else{
      this.snackBar.open('Ce festival n"est pas dans le panier ', 'OK', {
        duration: 3000,
        panelClass: ['info-snackbar']
    });
    }
    
  }
  

  addCamp(heber : panierHeber){
    if(this.hebExist(heber.idC)){
      this.snackBar.open('Cet emplacement est déja reservé', 'OK', {
        duration: 3000,
        panelClass: ['info-snackbar']
    });
    }else{
    let hb : panierHeber = {
      "idHeber" : heber.idHeber,
      "idC" : heber.idC,
      "dateD" : heber.dateD,
      "dateF" : heber.dateF, 
      "nbPlaces":heber.nbPlaces,  
      "prix" : heber.prix
    }
    this.hebergementsList.push(hb);
    this.snackBar.open('Vous avez résrver un emplacement du '+hb.dateD+' au '+hb.dateF, 'OK', {
      duration: 3000,
      panelClass: ['info-snackbar']
  });
  }
  }
  hebExist(idP:number):boolean{
    for (let index = 0; index < this.hebergementsList.length; index++) {
      if(this.hebergementsList[index].idC===idP) {
        this.indexHeb=index;
        return true;
      }     
    }
    return false;
  }

   removeH(index : number) {
    if(this.hebExist(index)){
      this.hebergementsList.splice(this.indexHeb,1);
      this.snackBar.open('Vous avez supprimer un camping de votre panier ', 'OK', {
        duration: 3000,
        panelClass: ['info-snackbar']
    });
    this.getTotal();
    
  }else{
    this.snackBar.open('Ce camping n"est pas dans le panier ', 'OK', {
      duration: 3000,
      panelClass: ['info-snackbar']
  });
  }  
  }
getTotal():number{
  let totF:number=0;
  let totH:number=0;
  if(this.hebergementsList!=[]){
    for (let index = 0; index < this.hebergementsList.length; index++) {
     totH+=this.hebergementsList[index].prix
    }
  }
  if(this.festvalsList!=[]){
    for (let index = 0; index < this.festvalsList.length; index++) {
     totF+=this.festvalsList[index].prix;
    }
  }
  return totF+totH;
}
   getPanier() : panier {
    let panier :panier={
      festivals:this.festvalsList,
      herbergs:this.hebergementsList,
      total:this.getTotal()
    };
    return panier;
  }
  getNbPlaces(idP:number):number{
    if(this.placeExist(idP)){
      return this.festvalsList[this.indexPlace].nbPlaces;
    }
    return 0;
  }

  validerPanier():boolean{
    if(this.hebergementsList.length!=0 && this.festvalsList.length!=0){
      for (let index = 0; index < this.festvalsList.length; index++) {
        for (let i = 0; i < this.hebergementsList.length; i++) {
          if(this.festvalsList[index].nbPlaces<=this.hebergementsList[i].nbPlaces){
            return true;
          }
        }
        
      }
    }
    return false;
  }

}


