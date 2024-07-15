{
  description = "Nim project flake";
  inputs = {
    nixpkgs.url = "github:nixos/nixpkgs/nixos-unstable";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = {
    self,
    nixpkgs,
    flake-utils,
  }:
    flake-utils.lib.eachDefaultSystem (sys: let
      pkgs = nixpkgs.legacyPackages.${sys};
    in {
      devShell = pkgs.mkShell {
        buildInputs = with pkgs; [
          # Gleam stack
          erlang
          rebar3
          gleam

          nim
          exercism
        ];
      };
    });
}
