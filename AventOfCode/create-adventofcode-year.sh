#!/bin/bash

# Check if the correct number of arguments is provided
if [ "$#" -ne 1 ]; then
    echo "Usage: $0 <year>"
    exit 1
fi

year=$1

# Find all folders that start with "src"
src_folders=$(find src/ -maxdepth 2 -type d -name "c*")

# Iterate over each "src" folder
for src_folder in $src_folders; do
    # Extract the output directory from the "src" folder
    output_directory="src/$(basename "$src_folder")"

    # Create the base package directory
    package_directory="${output_directory}/advent/code${year}"
    mkdir -p "${package_directory}"

    # Create 25 folders inside the base package directory
    for day in {1..25}; do
		formatted_day=$(printf "%02d" "$day")
        day_directory="${package_directory}/day${formatted_day}"
        mkdir -p "$day_directory"
        day_import="$(basename "$src_folder").advent.code${year}.day${formatted_day}";
        # Create FirstPart.java
        echo "package ${day_import};
public class FirstPart {
    public static void main(String[] args) {
        System.out.println(\"Day ${day} - First Part\");
    }
}" > "${day_directory}/FirstPart.java"

        # Create SecondPart.java
        echo "package ${day_import};
public class SecondPart {
    public static void main(String[] args) {
        System.out.println(\"Day ${day} - Second Part\");
    }
}" > "${day_directory}/SecondPart.java"
    done

    echo "Folders and files created successfully in ${output_directory}."
done
