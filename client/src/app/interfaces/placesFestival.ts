export interface placesFestival{
    num:number,
    places:places[]
}
export interface places{
        id: number,
        categ:number,
        date:string,
        festival: string,
        nbPlaces:number,
        prix:number

}