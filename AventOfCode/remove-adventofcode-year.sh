#!/bin/bash

# Check if the correct number of arguments is provided
if [ "$#" -ne 1 ]; then
    echo "Usage: $0 <year>"
    exit 1
fi

year=$1

# Find all folders that start with "src"
src_folders=$(find . -type d -name "src*")

# Iterate over each "src" folder
for src_folder in $src_folders; do
    # Extract the output directory from the "src" folder
    output_directory=$(basename "$src_folder")

    # Create the base package directory
    package_directory="${output_directory}/advent/code${year}"
    rm -rf "${package-directory}"
done
