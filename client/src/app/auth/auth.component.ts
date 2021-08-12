import { Component, OnInit } from '@angular/core';
import { AuthService } from './../services/Authservice/auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import * as firebase from 'firebase';
import { ClientInterface } from 'app/interfaces/ClientInterface';
import { Subscription } from 'rxjs/Subscription';
import { Location } from '@angular/common';
import { NgxSpinnerService } from "ngx-spinner";
import{ClientService} from 'app/services/ClientService/client-service.service';
import { MatSnackBar } from '@angular/material';
@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']
})
export class AuthComponent implements OnInit {
    signupForm: FormGroup;
    signinForm: FormGroup;
    errorMessage: string;
    constructor(private formBuilder: FormBuilder,private location: Location,private SpinnerService: NgxSpinnerService,
                private authService: AuthService, private clientServ: ClientService,public snackBar: MatSnackBar,
                private router: Router) {

    }

    ngOnInit() {
        this.initForm();

    }


    initForm() {
        this.signinForm = this.formBuilder.group({
            email: ['', [Validators.required, Validators.email]],
            password: ['', [Validators.required, Validators.pattern(/[0-9a-zA-Z]{6,}/)]]
        });
        this.signupForm = this.formBuilder.group({
            emailS: ['', [Validators.required, Validators.email]],
            passwordS:['', Validators.required],
            nom: ['', Validators.required],
            prenom: ['', Validators.required]
          });
    }
    public back() {
      this.location.back();
    }

    async signInWithFacebook() {
      this.SpinnerService.show();
       await  this.authService.signInWithFacebook()
            .then(() => {       
          
            },
            (error) => {
              this.errorMessage = error;
            }
          ); 
          
          const newClient = new ClientInterface(this.authService.getNameUser(),this.authService.getSecNameUser(),"Client");
          this.authService.addToFirebase(newClient);
          this.SpinnerService.hide();
          this.snackBar.open("Bienvenu sur notre application "+this.authService.getNameUser(), 'OK',{
            duration: 2000 ,
            panelClass: ['error-snackbar']
          });
          this.router.navigate(["/Home"]);
    }
    async signInWithGoogle() {
        this.SpinnerService.show();
        await this.authService.signInWithGoogle()
            .then((res) => {
             
            })
            .catch((err) => this.errorMessage=err);
            const newClient = new ClientInterface(this.authService.getNameUser(),this.authService.getSecNameUser(),"Client");
          this.authService.addToFirebase(newClient);
          this.SpinnerService.hide();
          this.snackBar.open("Bienvenu sur notre application "+this.authService.getNameUser(), 'OK',{
            duration: 2000 ,
            panelClass: ['error-snackbar']
          });
          this.router.navigate(["/Home"]);
    }


   async onSubmit() {
        const email = this.signinForm.get('email').value;
        const password = this.signinForm.get('password').value;
        this.SpinnerService.show();
        await this.authService.signInUser(email, password).then(
            () => {

            },
            (error) => {
                this.errorMessage = error;
            }
        );
        this.SpinnerService.hide();
        this.router.navigate(["/Home"]);
    }
    async signUp() {
        const email = this.signupForm.get('emailS').value;
        const password = this.signupForm.get('passwordS').value;
        const nom =this.signupForm.get('nom').value;
        const prenom =this.signupForm.get('prenom').value;
        const etat ="client";
        this.SpinnerService.show();
        await this.authService.createNewUser(email, password).then(
          () => {
          
          },
          (error) => {
            this.errorMessage = error;
          }
        );
        this.SpinnerService.hide();
        const newClient = new ClientInterface(nom,prenom,etat);
        this.authService.addToFirebase(newClient);
        this.snackBar.open("Bienvenu sur notre application "+prenom, 'OK',{
          duration: 2000 ,
          panelClass: ['error-snackbar']
        });
        this.router.navigate(['/Home']);
        
      }


}
