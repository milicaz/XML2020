import { MarkaAuta } from './markaAuta';
import { ModelAuta } from './modelAuta';
import { KlasaAuta } from './klasaAuta';
import { VrstaGoriva } from './vrstaGoriva';
import { TipMenjaca } from './tipMenjaca';

export class Automobil {
    id: number;
    markaAutomobila: MarkaAuta;
    modelAutomobila: ModelAuta;
    klasaAutomobila: KlasaAuta;
    vrstaGoriva: VrstaGoriva;
    tipMenjaca: TipMenjaca;
    kilometraza: number;
    dozvoljenaKilometraza: number;
    cdw: boolean;
    decijaSedista: bigint;
}
