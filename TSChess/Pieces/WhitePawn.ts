import { Board } from "../Board";
import { Move } from "../Move";
import { Piece, PieceType } from "./Piece";

export class WhitePawn implements Piece {

    kind : PieceType = PieceType.Pawn;

    isWhite : boolean = true;

    

    constructor( isWhite : boolean ){
        this.isWhite = isWhite;
    }
    generateMoves: (moveOn: Board, row: number, col: number) => Move[] = 
         (moveOn: Board, row: number, col: number)  => {

            let whitePawnMoves : Move[]  = [];

            


            return null;
         }

}