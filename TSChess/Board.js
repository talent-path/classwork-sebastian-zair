"use strict";
var __spreadArrays = (this && this.__spreadArrays) || function () {
    for (var s = 0, i = 0, il = arguments.length; i < il; i++) s += arguments[i].length;
    for (var r = Array(s), k = 0, i = 0; i < il; i++)
        for (var a = arguments[i], j = 0, jl = a.length; j < jl; j++, k++)
            r[k] = a[j];
    return r;
};
exports.__esModule = true;
var Bishop_1 = require("./Pieces/Bishop");
var King_1 = require("./Pieces/King");
var Knight_1 = require("./Pieces/Knight");
var Queen_1 = require("./Pieces/Queen");
var Rook_1 = require("./Pieces/Rook");
var ChessBoard = /** @class */ (function () {
    function ChessBoard(copyFrom) {
        var _this = this;
        this.makeMove = function (toMake) {
            //TODO: enpassant stuff
            //TODO: 50 move rule stuff
            var nextBoard = new ChessBoard(_this);
            var oldPiece = nextBoard.allSquares[toMake.from.row][toMake.from.col];
            nextBoard.allSquares[toMake.from.row][toMake.from.col] = null;
            nextBoard.allSquares[toMake.to.row][toMake.to.col] = oldPiece;
            return nextBoard;
        };
        if (copyFrom) {
            this.buildFrom(copyFrom);
        }
        this.allSquares = [];
        for (var row = 0; row < 8; row++) {
            this.allSquares[row] = [];
            for (var col = 0; col < 8; col++) {
                // if( row === 6 ){
                //     this.allSquares[row][col] = {kind: PieceType.Pawn, isWhite: false};
                // }
                // if( row === 1 ){
                //     this.allSquares[row][col] = {kind: PieceType.Pawn, isWhite: true};
                // }
                // if( row === 1 || row === 6 ){
                //     this.allSquares[row][col] =  row === 1 ? new WhitePawn() : new BlackPawn();
                // }
                if ((row === 0 || row === 7) && (col === 0 || col === 7)) {
                    this.allSquares[row][col] = new Rook_1.Rook(row === 0);
                }
                if ((row === 0 || row === 7) && (col === 1 || col === 6)) {
                    this.allSquares[row][col] = new Knight_1.Knight(row === 0);
                }
                if ((row === 0 || row === 7) && (col === 2 || col === 5)) {
                    this.allSquares[row][col] = new Bishop_1.Bishop(row === 0);
                }
                if (col === 3 && (row === 0 || row === 7)) {
                    this.allSquares[row][col] = new Queen_1.Queen(row === 0);
                }
                if (col === 4 && (row === 0 || row === 7)) {
                    this.allSquares[row][col] = new King_1.King(row === 0);
                }
                if (!this.allSquares[row][col]) {
                    this.allSquares[row][col] = null;
                }
            }
        }
    }
    //  rnbqkbnr        7
    //  pppppppp        6
    //  ........        5
    //  ........        4
    //  ........        3
    //  ........        2
    //  PPPPPPPP        1
    //  RNBQKBNR        0
    //  01234567
    ChessBoard.prototype.pieceAt = function (loc) {
        return this.allSquares[loc.row][loc.col];
    };
    ChessBoard.prototype.buildFrom = function (toCopy) {
        // [a, b, c]
        // [[a, b, c]]
        this.allSquares = [];
        for (var i = 0; i < toCopy.allSquares.length; i++) {
            this.allSquares.push(__spreadArrays(toCopy.allSquares[i]));
        }
    };
    ChessBoard.prototype.generateMoves = function () {
        var allMoves = [];
        for (var row = 0; row < 8; row++) {
            for (var col = 0; col < 8; col++) {
                if (this.allSquares[row][col]) {
                    allMoves.push.apply(allMoves, this.allSquares[row][col].generateMoves(this, { row: row, col: col }));
                }
            }
        }
        return allMoves;
    };
    return ChessBoard;
}());
console.log("attempting to create a board");
var testBoard = new ChessBoard();
console.log("done creating a board:");
//console.log( testBoard );
testBoard = testBoard.makeMove({ from: { row: 1, col: 3 }, to: { row: 3, col: 3 } });
console.log(testBoard.generateMoves());
