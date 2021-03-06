import { Component, Input, OnInit } from '@angular/core';
//import {Piece} from 'chess/TSChess/Pieces';
import { Bishop } from '../chess/TSChess/Pieces/Bishop';
import { Piece, PieceType } from '../chess/TSChess/Pieces/Piece';
@Component({
  selector: 'app-chess-square',
  templateUrl: './chess-square.component.html',
  styleUrls: ['./chess-square.component.css']
})
export class ChessSquareComponent implements OnInit {

  @Input()squarePiece: Piece = new Bishop(true);
  imageSrc: string = "./assets/";
  @Input()row: number = 0;
  @Input()col: number = 7;
  isLightSquare: boolean = true;
  constructor() {
    
  }

  // safer to have your code in the ngOnInit
  ngOnInit(): void {
    if(this.squarePiece == null){
      this.imageSrc = "";
    }else{

    
    this.imageSrc += this.squarePiece.isWhite ? "w":"b";
    switch(this.squarePiece.kind){
      case PieceType.Bishop: this.imageSrc+= "B"; break;
      case PieceType.Knight: this.imageSrc+= "N"; break;
      case PieceType.Rook: this.imageSrc+= "R"; break;
      case PieceType.Queen: this.imageSrc+= "Q"; break;
      case PieceType.King: this.imageSrc+= "K"; break;
      case PieceType.Pawn: this.imageSrc+= "P"; break;
    }
    this.imageSrc += ".png";
  }
    // now calculate the value of the squares you'll alternate:
    this.isLightSquare = (this.row + this.col) % 2 === 0;
  }

}
