import { Component, OnInit } from '@angular/core';
import {OrdonnanceService} from '../services/ordonnance.service';
import * as jsPDF from 'jspdf'
import {Ordonnance} from '../classes/ordonnance';
declare var swal: any;

@Component({
  selector: 'app-ordonnance',
  templateUrl: './ordonnance.component.html',
  styleUrls: ['./ordonnance.component.css']
})
export class OrdonnanceComponent implements OnInit {
  public ords;

  public ord:Ordonnance = new Ordonnance();
  constructor(private ordonnanceService: OrdonnanceService) { }

  ngOnInit() {
    this.ordonnanceService.getAll().subscribe((data :any)=>{
      this.ords = data;
      console.log(this.ords[0].consultation.motif);
    });
    console.log(localStorage);

  }

  printPDF(id){
    console.log(id);
    this.ordonnanceService.getOrdonnace(id).subscribe((data:any) =>{
      this.ord.dateOr = data.body.dateOr;
      this.ord.consultation = data.body.consultation;
      this.ord.consultation.Diagnostic = data.body.consultation.diagnostic;
      this.ord.id = data.body.id;
    })
    //console.log('pdf = >> ' + this.ords.consultation.id);
    let doc = new jsPDF();
    console.log(this.ord)
    doc.text('Cabinet Medical ', 80, 19)
    doc.text('Ordonnance : ' , 15, 40);
    doc.text('Medecin : Alami Youness' , 120, 60);
    doc.text('Le  : ' + this.ord.consultation.dateC, 20, 80);
    doc.text('Diagnostic : ' + this.ord.consultation.Diagnostic, 20,100);
    doc.text('Type de consultation : ' + this.ord.consultation.typeConsultation.libelle, 20, 120);
    doc.text('Montant : ' + this.ord.consultation.price, 20, 140);
    doc.text('Commentaire : ', 20, 160);
    doc.text('Signature : ', 100, 250);
    doc.save('OrdonnancePDF.pdf')
  }

  delete(id){
    this.ordonnanceService.delete(id).subscribe((data:any)=>{
      swal('Consultation Supprimé!', '', 'success');
      this.ordonnanceService.getAll().subscribe((data: any) =>{
        this.ords = data;
      })
    })
  }



}
