#!/bin/bash
set -e # Exit with nonzero exit code if anything fails

echo "Generando docs ..."

# Generate Maven site
echo "Generando sitio web de Maven ..."
pushd "$(git rev-parse --show-toplevel)"
mvn clean site

# Generate Doxygen docs
echo "Generando docs de Doxygen ..."
pushd ./doxygen
doxygen Doxyfile
popd +1

echo "Generacion de docs finalizada"
