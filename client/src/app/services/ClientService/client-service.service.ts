import {Injectable ,HostBinding} from '@angular/core';
import * as firebase from 'firebase';
import { AuthService } from '../Authservice/auth.service';
//import { AngularFire, AuthProviders, AuthMethods } from 'angularfire2';
import { Router } from '@angular/router';
import { AngularFireAuth } from 'angularfire2/auth';
import {HttpClient} from '@angular/common/http';
import { ClientInterface } from 'app/interfaces/ClientInterface';
import { from ,Subject} from 'rxjs';
@Injectable()
export class ClientService {
  client = new ClientInterface("","","");
	ClientSubject = new Subject<ClientInterface[]>();
  constructor(public af: AngularFireAuth,private router: Router,  http: HttpClient, 
    private authServ : AuthService) { }
  getSingleBook() {
    return new Promise(
      (resolve, reject) => {
        firebase.database().ref('Client/' + localStorage.getItem('currentUser')).once('value').then(
          (data) => {
            this.client=(data.val());
            resolve(data.val());
          }, (error) => {
            reject(error);
          }
        );
      }
    );
  }
  Modifier(newClient :ClientInterface){
    console.log(newClient);
    console.log(localStorage.getItem('currentUser'));
    firebase.database().ref('Client/'+localStorage.getItem('currentUser')).set(newClient);
  //	this.ClientSubject.next(this.client);
    }

   // this.client= new ClientInterface("","","");
 
estclient():boolean{
  if(this.client){
    if(this.client.state=="Client"){
      return true;
    }
  }  
  return false;
} 
estheberg():boolean{
  if(this.client){
    if(this.client.state=="Hébergeur"){
      return true;
    }
  }
  return false;
}
estOrg():boolean{
  if(this.client){
    if(this.client.state=="Organisateur"){
      return true;
    }
  }  
  return false;
}
}
