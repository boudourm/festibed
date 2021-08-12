import { Injectable } from '@angular/core';
import { festival } from 'app/interfaces/festival';
import {placesFestival} from 'app/interfaces/placesFestival';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { HttpClientModule } from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class FestivalServiceService {
  festival :festival[];
  places:placesFestival[]=[{num:1,places:[{id: 1,categ:1,date:"17/12/2020",festival: "KD243", nbPlaces:12,prix:15},
  {id:2,categ:1,date:"18/12/2020",festival: "KD243",nbPlaces:19,prix:15},
  {id: 3,categ:2,date:"17/12/2020",festival: "KD243",nbPlaces:12,prix:5},]},
  {num:2,places:[{id: 1,categ:1,date:"17/12/2020",festival: "KD243",nbPlaces:12,prix:5}]}];
  private _http: HttpClient;
  public get http(): HttpClient { return this._http; };

  constructor( http: HttpClient ) {
    this._http = http;
}
async getFestivals(): Promise<festival[]>{
  const response = await this.http.get("/api/festivals").toPromise();
 return <festival[]>response;
}
/**/
async getFestivalByID(id :string):Promise<festival>{
  const resp = await this.http.get("/api/festivals?id="+id).toPromise()
  return <festival>resp;
}
async getFestivalPLaces(id:string):Promise<placesFestival[]>{
 const response= await this.http.get("/api/places?id="+id).toPromise();
return <placesFestival[]>response;
}

  async getRechercheFest(dateD:string,dateF:string,nom:string,dep:string,dom:string,reg:string,prixF:string):Promise<festival[]> {
    const response= await this.http.get("/api/festivals?dateD="+dateD+"?dateF="+dateF+"?nom="+nom+"?dep="+dep+"?dom="+dom+"?reg="+reg+"?prixF="+prixF).toPromise();
    return <festival[]>response;
  }

}
