import {panierFestival} from './panierFestival';
import {panierHeber} from './panierHeber';
export interface panier{
    festivals:panierFestival[],
    herbergs:panierHeber[],
    total:number
}