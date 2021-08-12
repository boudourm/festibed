import {Injectable ,HostBinding} from '@angular/core';
import * as firebase from 'firebase';
//import { AngularFire, AuthProviders, AuthMethods } from 'angularfire2';
import { Router } from '@angular/router';
import { Observable} from 'rxjs/Observable';
import { AngularFireAuthModule } from 'angularfire2/auth';
import { AngularFireAuth } from 'angularfire2/auth';
import {HttpClient} from '@angular/common/http';
import { from ,Subject} from 'rxjs';
import { ClientInterface } from 'app/interfaces/ClientInterface';
import { MatSnackBar } from '@angular/material';
@Injectable()
export class AuthService {
    private user: Observable<firebase.User>;
    private userDetails: firebase.User = null;
    uidUser:string;
    error: any;
    nameUser:string;
    secNameUser:string;
	client : ClientInterface= new ClientInterface("","","");
	ClientSubject = new Subject<ClientInterface[]>();
  public isLogin:boolean =false;
    private _http: HttpClient;
    public get http(): HttpClient { return this._http; }


    constructor(public snackBar: MatSnackBar,public af: AngularFireAuth,private router: Router,  http: HttpClient ) {
      this.infoUser();
    }
    infoUser(){
      this.af.user.subscribe( 
        u => { 
          if(u){
            this.isLogin = true;
            this.uidUser=u.uid;
            //console.log(u);
          }
          else{
            this.isLogin = false;
            //initalise l'idToken à null
            localStorage.clear();
            //redirection vers la page login
            this.router.navigate(['/Login']);
          }
  
        }
      );	
    }


  createNewUser(email: string , mdp: string ){
    return new Promise(
      (resolve,reject)=>{

        firebase.auth().createUserAndRetrieveDataWithEmailAndPassword(email,mdp).then(
          ()=>{
            this.isLogin=true;
            
            localStorage.setItem('currentUser', this.uidUser);
            resolve();
          },
          (error)=>{
            reject(error);
          }
        );
      }
	);
	
			
			
			
  }
  verif(){
    firebase.auth().onAuthStateChanged((user) => {
      if (user) {
        // User logged in already or has just logged in.
        this.uidUser=user.uid;
        this.isLogin=true;
        console.log(user.uid);
        console.log(this.uidUser);
      } else {
        // User not logged in or has just logged out.
  
      }
    });
  }
  addToFirebase(newClient :ClientInterface){
    
	console.log(newClient);
	this.client=(newClient);
	firebase.database().ref('Client/'+this.uidUser).set(this.client);
//	this.ClientSubject.next(this.client);
this.snackBar.open("Bienvenu sur notre application "+this.client.nom, 'OK',{
  duration: 2000 ,
  panelClass: ['error-snackbar']
});
  }

  getIdUser():any {
        return this.uidUser;
  }

  signInUser(email: string , mdp: string ){
    return new Promise(
      (resolve,reject)=>{
        firebase.auth().signInWithEmailAndPassword(email,mdp).then(
          ()=>{
            this.isLogin=true;
            
            localStorage.setItem('currentUser', this.uidUser);
              resolve();

          },
          (error)=>{
            reject(error);
          }
        );
      }
    );
  }
    signInWithGoogle() {
      let i;
        return new Promise(
          (resolve,reject)=>{
            this.af.auth.signInWithPopup(new firebase.auth.GoogleAuthProvider()).then(
              res=>{
                this.isLogin=true;
                i = res.user.displayName.indexOf(" "); 							
                this.uidUser= res.user.uid;
                this.nameUser= res.user.displayName.substr(0, i);
                this.secNameUser= res.user.displayName.substr(i);
                resolve();
                localStorage.setItem('currentUser', this.uidUser);
              },
              (error)=>{
                reject(error);
              }
            );
          }
        );
         
    }

    signInWithFacebook() {
      let i;
        return new Promise(
          (resolve,reject)=>{
            this.af.auth.signInWithPopup(new firebase.auth.FacebookAuthProvider() ).then(
              res =>{
                    this.isLogin=true;
                    i = res.user.displayName.indexOf(" "); 							
										this.uidUser= res.user.uid;
										this.nameUser= res.user.displayName.substr(0, i);
                    this.secNameUser= res.user.displayName.substr(i);  
                localStorage.setItem('currentUser', this.uidUser);
                resolve();
              },
              (error)=>{
                reject(error);
              }
            );
          }
        );
    }
getNameUser():string{
  return this.nameUser;
}
getSecNameUser():string{
  return this.secNameUser;
}
  
  async signOut(){
    this.isLogin=false;
    await this.af.auth.signOut().then( 
			res =>{			
				this.infoUser();
			}, err => {
				console.log(err);
			}
		);
  
  }
  


}
