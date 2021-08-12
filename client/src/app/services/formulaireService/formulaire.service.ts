import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { departements } from 'app/interfaces/departements';
import { domaines } from 'app/interfaces/domaines';
import { regions } from 'app/interfaces/regions';
@Injectable({
  providedIn: 'root'
})
export class FormulaireService {
  private _http: HttpClient;
  public get http(): HttpClient { return this._http; };
  constructor( http: HttpClient ) {
    this._http = http;
}
//recuperer les departements
async getDepartements() :Promise<departements[]>{
  const response = await this.http.get("/api/departements").toPromise();
  return <departements[]>response;
}
//recuperer les domaines de festival
async getDomaines():Promise<domaines[]>{
  const response = await this.http.get("/api/domaines").toPromise();
  return <domaines[]>response;
}
//recuperer les regions
async getRegions(): Promise<regions[]>{
  const response= await this.http.get("/api/regions").toPromise();
  return <regions[]> response;
}
}
