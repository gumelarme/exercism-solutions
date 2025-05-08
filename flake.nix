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
      requirements = packages: pkgs.mkShell {
          buildInputs = [ pkgs.exercism ] ++ packages;
      };
    in {
      devShells = {
        gleam = requirements (with pkgs; [
          erlang
          rebar3
          gleam
        ]);

        clojure = requirements (with pkgs; [
          jdk8_headless
          clojure
          leiningen
        ]);

        nim = requirements (with pkgs; [
          nim
        ]);

        zig = requirements (with pkgs; [
          zig 
          zls
        ]);

        prolog = requirements (with pkgs; [
          swi-prolog
        ]);
      };
    });
}
