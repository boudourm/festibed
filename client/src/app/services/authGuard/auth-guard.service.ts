import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material';
import { Router } from '@angular/router';
import { Observable} from 'rxjs/Observable';
import * as firebase from 'firebase';
import {AuthService} from '../Authservice/auth.service';
@Injectable({
  providedIn: 'root'
})
export class AuthGuardService {

  constructor(public snackBar: MatSnackBar,private router: Router,private authserv :AuthService) { }
  canActivate(): Observable<boolean> | Promise<boolean> | boolean {
		return new Promise(
		  (resolve, reject) => {
			firebase.auth().onAuthStateChanged(
			  (user) => {

					if(user) {				 
						resolve(true); 
					} 
					else {
						//si il y a aucun user, redirection vers la page login
						this.router.navigate(['Login']); 
						this.snackBar.open("Accès refusé", 'OK',{
							duration: 2000 ,
							panelClass: ['error-snackbar']
						});
						reject(false);
					}
					
			  }
			);
		  }
		);
  }
}
