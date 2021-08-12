import { Injectable } from '@angular/core';
import { Villagevacance} from 'app/interfaces/villagevacance';
import { Hotel} from 'app/interfaces/hotel';
import { Camping} from 'app/interfaces/camping';
import { Residence} from 'app/interfaces/residence';
import{hebergement} from 'app/interfaces/hebergement';
import {HttpClient} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class HebergementService {

 

  villageVacance : Villagevacance[]=[];
  Camping : Camping[]=[];
  Residence: Residence[]=[];

 
  private _http: HttpClient;
  public get http(): HttpClient { return this._http; };

  constructor( http: HttpClient ) {
    this._http = http;
  }
  async getVillagVac():Promise<Villagevacance[]>{
    const response=await this.http.get("/api/villagesvacances").toPromise();
    return <Villagevacance[]>response;
  }

  getVillageVacanceById(id:number):Villagevacance{
    return this.villageVacance[id];
  }
  async getCampingById(id:number):Promise<Camping>{
    const response=await this.http.get("/api/campings?id="+id).toPromise();
    return <Camping>response;
  }
  getResidenceById(id:number):Residence{
    return this.Residence[id];
  }
  async getHotels():Promise<Hotel[]>{
    const response = await this.http.get("/api/hotels").toPromise();
    return <Hotel[]>response;
  }
  async getCampings():Promise<Camping[]>{
    const response=await this.http.get("/api/campings").toPromise()
    return <Camping[]>response;
  }
  async getResidences():Promise<Residence[]>{
    const response = await this.http.get("/api/residences").toPromise();
    return <Residence[]>response;
  }

  


}
