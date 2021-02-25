import { Component, OnInit } from '@angular/core';
import { Board, ChessBoard } from '../chess/TSChess/Board';

@Component({
  selector: 'app-chess-board',
  templateUrl: './chess-board.component.html',
  styleUrls: ['./chess-board.component.css']
})
export class ChessBoardComponent implements OnInit {

  board: ChessBoard = new ChessBoard();
  constructor() { }

  ngOnInit(): void {
  }

}
//hi