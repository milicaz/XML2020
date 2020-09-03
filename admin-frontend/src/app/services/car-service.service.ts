import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { KlasaAuta } from '../model/klasaAuta';

@Injectable({
  providedIn: 'root'
})
export class CarServiceService {

  constructor(private http: HttpClient) { }

  getAllKlasaAuta() {
    console.log('Usao u getAllKlasaAuta');
    return this.http.get('http://localhost:8762/car-service/api/klasaAuta/all');
  }

  getKlasaAutaById(id) {
    console.log('Trazenje klase auta po id-ju');
    return this.http.get('http://localhost:8762/car-service/api/klasaAuta/' + id);
  }

  addKlasaAuta(klasaAuta: KlasaAuta) {
    console.log('Dodavanje klase auta');
    return this.http.post('http://localhost:8762/car-service/api/klasaAuta', klasaAuta);
  }

  editKlasaAuta(id, klasaAuta: KlasaAuta) {
    console.log('Editovanje klase auta');
    return this.http.put('http://localhost:8762/car-service/api/klasaAuta' + id, klasaAuta);
  }

  deleteKlasaAuta(id) {
    console.log('Brisanje klase auta');
    return this.http.delete('http://localhost:8762/car-service/api/klasaAuta' + id);
  }


}
