PBM_FILES := $(shell find Illustrations -mindepth 2 -type f -name '*.pbm')
RENDERED_PBM_FILES = $(patsubst %.pbm,%.pdf,${PBM_FILES})

SVG_FILES := $(shell find Illustrations -mindepth 2 -type f -name '*.svg')
RENDERED_SVG_FILES = $(patsubst %.svg,%.pdf,${SVG_FILES})

DOT_FILES := $(shell find Illustrations -mindepth 2 -type f -name '*.dot')
RENDERED_DOT_FILES = $(patsubst %.dot,%.pdf,${DOT_FILES})

MP_FILES := $(shell find Illustrations -mindepth 2 -type f -name '*.mp')
RENDERED_MP_FILES = $(patsubst %.mp,%.pdf,${MP_FILES})

.PHONY: all clean

all: Crypto101.pdf

Crypto101.pdf: ${RENDERED_PBM_FILES} ${RENDERED_SVG_FILES} ${RENDERED_DOT_FILES} ${RENDERED_MP_FILES} Crypto101.tex Header.tex Glossary.tex Crypto101.bib
	latexmk -bibtex -pdf -f Crypto101.tex

Crypto101.tex: Crypto101.org
	./org2tex Crypto101.org

%.pdf: %.pbm
	potrace -b pdf $<

%.pdf: %.svg
	inkscape $(realpath $<) --export-pdf=$(addprefix ${CURDIR}/,$@)

%.pdf: %.dot
	neato -Tpdf $(realpath $<) > $(addprefix ${CURDIR}/,$@)

%.pdf: %.mp
	cd $(dir $<) && mptopdf --metafun $(notdir $<)
	mv $(addsuffix -mps.pdf,$(basename $<)) $(addsuffix .pdf,$(basename $<))

clean:
	git clean -fdx
