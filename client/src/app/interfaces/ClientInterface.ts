export class ClientInterface{
    id : string;
    nom  : string;
    prenom:string;
    etat:string;
    constructor(public name: string, public secondName: string, public state: string) {
    }
}