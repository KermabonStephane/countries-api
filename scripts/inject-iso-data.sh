#!/bin/bash

API_BASE_URL="http://localhost:8080/api/v1"

echo "Injecting ISO 3166 countries data..."

# Function to create a country
create_country() {
    local alpha2=$1
    local alpha3=$2
    local name=$3
    local region=$4
    local subregion=$5

    curl -X POST "${API_BASE_URL}/countries" \
         -H "Content-Type: application/json" \
         -d "{
             \"alpha2Code\": \"$alpha2\",
             \"alpha3Code\": \"$alpha3\",
             \"name\": \"$name\",
             \"region\": \"$region\",
             \"subregion\": \"$subregion\"
         }"
    echo ""
}

# Create regions first
echo "Creating regions..."
curl -X POST "${API_BASE_URL}/regions" \
     -H "Content-Type: application/json" \
     -d '{"name": "Europe", "description": "European countries", "code": 150}'

curl -X POST "${API_BASE_URL}/regions" \
     -H "Content-Type: application/json" \
     -d '{"name": "Asia", "description": "Asian countries", "code": 142}'

curl -X POST "${API_BASE_URL}/regions" \
     -H "Content-Type: application/json" \
     -d '{"name": "Africa", "description": "African countries", "code": 2}'

curl -X POST "${API_BASE_URL}/regions" \
     -H "Content-Type: application/json" \
     -d '{"name": "Americas", "description": "American countries", "code": 19}'

curl -X POST "${API_BASE_URL}/regions" \
     -H "Content-Type: application/json" \
     -d '{"name": "Oceania", "description": "Oceanic countries", "code": 9, "subRegions": [{"code": 54, "name": "Melanesia"}, {"code": 57, "name": "Micronesia"}, {"code": 61, "name": "Polynesia"}, {"code": 58, "name": "Australia and New Zealand"}]}'

# Create sub-regions
echo "Creating sub-regions..."
curl -X POST "${API_BASE_URL}/subregions" \
     -H "Content-Type: application/json" \
     -d '{"name": "Western Europe", "region": "Europe", "description": "Western European countries"}'

curl -X POST "${API_BASE_URL}/subregions" \
     -H "Content-Type: application/json" \
     -d '{"name": "Eastern Europe", "region": "Europe", "description": "Eastern European countries"}'

curl -X POST "${API_BASE_URL}/subregions" \
     -H "Content-Type: application/json" \
     -d '{"name": "Northern Europe", "region": "Europe", "description": "Northern European countries"}'

curl -X POST "${API_BASE_URL}/subregions" \
     -H "Content-Type: application/json" \
     -d '{"name": "Southern Europe", "region": "Europe", "description": "Southern European countries"}'

curl -X POST "${API_BASE_URL}/subregions" \
     -H "Content-Type: application/json" \
     -d '{"name": "Australia and New Zealand", "region": "Oceania", "description": "Australia and New Zealand countries"}'

curl -X POST "${API_BASE_URL}/subregions" \
     -H "Content-Type: application/json" \
     -d '{"name": "Melanesia", "region": "Oceania", "description": "Melanesia countries"}'

curl -X POST "${API_BASE_URL}/subregions" \
     -H "Content-Type: application/json" \
     -d '{"name": "Micronesia", "region": "Oceania", "description": "Micronesia countries"}'

curl -X POST "${API_BASE_URL}/subregions" \
     -H "Content-Type: application/json" \
     -d '{"name": "Polynesia", "region": "Oceania", "description": "Polynesia countries"}'

# Sample countries data
echo "Creating countries..."
create_country "FR" "FRA" "France" "Europe" "Western Europe"
create_country "DE" "DEU" "Germany" "Europe" "Western Europe"
create_country "IT" "ITA" "Italy" "Europe" "Southern Europe"
create_country "ES" "ESP" "Spain" "Europe" "Southern Europe"
create_country "GB" "GBR" "United Kingdom" "Europe" "Northern Europe"
create_country "US" "USA" "United States" "Americas" "North America"
create_country "CA" "CAN" "Canada" "Americas" "North America"
create_country "JP" "JPN" "Japan" "Asia" "Eastern Asia"
create_country "CN" "CHN" "China" "Asia" "Eastern Asia"
create_country "AU" "AUS" "Australia" "Oceania" "Australia and New Zealand"

echo "Data injection completed!"
