;;; Sierra Script 1.0 - (do not remove this comment)
(script# 525)
(include sci.sh)
(use Main)
(use LBRoom)
(use Inset)
(use CueObj)
(use n958)
(use Timer)
(use Sound)
(use View)
(use Obj)

(public
	rm525 0
)

(local
	theGLb2DoVerbCode
)
(procedure (localproc_0370)
	(proc0_8 1)
	(if (not (gEgo has: 31)) (grapes init:))
	(feIntercom init: setOnMeCheck: 1 4)
	(feDocBottom init: setOnMeCheck: 1 16)
	(feDocTop init: setOnMeCheck: 1 32)
	(feDesk init: setOnMeCheck: 1 128)
	(feDocDesk init: setOnMeCheck: 1 256)
	(feDocLeft init: setOnMeCheck: 1 512)
	(feBody init: setOnMeCheck: 1 1024)
	(feAnkle init: setOnMeCheck: 1 2048)
	(feLeg init: setOnMeCheck: 1 4096)
	(feHands init: setOnMeCheck: 1 16384)
	(feFace init: setOnMeCheck: 1 -32768)
	(gGame handsOn:)
	(gIconBar disable: 7)
)

(instance rm525 of LBRoom
	(properties
		picture 525
	)
	
	(method (init)
		(gIconBar disable: 7)
		(proc958_0 128 520 523 524 526)
		(proc958_0 129 556 525)
		(proc958_0 132 520 524 4 6 85)
		(self setRegions: 90)
		(= theGLb2DoVerbCode gLb2DoVerbCode)
		(= gLb2DoVerbCode exitDoVerbCode)
		(if (proc0_3 69)
			(= picture 525)
			(gWrapSound number: 6 loop: -1 flags: 1 play:)
			(localproc_0370)
		else
			(= picture 556)
			(wrapMusic init: -1 4 6)
			(sFX number: 85 flags: 1 loop: 1 play:)
			((Timer new:) setReal: self 3)
		)
		(super init:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13
				(proc0_8 0)
				(self newRoom: 520)
			)
			(else  (super doVerb: theVerb))
		)
	)
	
	(method (cue)
		(self drawPic: (= picture 525))
		(localproc_0370)
	)
	
	(method (newRoom newRoomNumber)
		(= gLb2DoVerbCode theGLb2DoVerbCode)
		(if inset (inset dispose:))
		(gIconBar enable: 7)
		(if (gSounds contains: wrapSong) (wrapMusic dispose: 1))
		(super newRoom: newRoomNumber)
	)
)

(instance grapes of View
	(properties
		x 224
		y 154
		noun 15
		view 526
		cel 1
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (global2 setInset: inGrapes))
			(8 (global2 setInset: inGrapes))
			(4 (global2 setInset: inGrapes))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance feIntercom of Feature
	(properties
		y 1
		noun 10
		sightAngle 40
	)
)

(instance feDocBottom of Feature
	(properties
		y 1
		noun 4
		sightAngle 40
	)
)

(instance feDocTop of Feature
	(properties
		y 1
		noun 7
		sightAngle 40
	)
)

(instance feDesk of Feature
	(properties
		y 1
		noun 3
		sightAngle 40
	)
)

(instance feDocDesk of Feature
	(properties
		y 1
		noun 5
		sightAngle 40
	)
)

(instance feDocLeft of Feature
	(properties
		y 1
		noun 6
		sightAngle 40
	)
)

(instance feBody of Feature
	(properties
		y 1
		noun 2
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(8
				(if (not (gEgo has: 13))
					(global2 setInset: inSmellingSalts)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance feAnkle of Feature
	(properties
		y 1
		noun 1
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(8
				(global2 setInset: inFeAnkle)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance feLeg of Feature
	(properties
		y 1
		noun 11
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(8
				(global2 setInset: inFeAnkle)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance feHands of Feature
	(properties
		y 1
		noun 9
		sightAngle 40
	)
)

(instance feFace of Feature
	(properties
		y 1
		noun 8
		sightAngle 40
	)
)

(instance inGrapes of Inset
	(properties
		view 526
		x 210
		y 144
		disposeNotOnMe 1
		noun 12
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13
				(proc0_8 0)
				(global2 newRoom: 520)
			)
			(4
				(gGame points: 1 165)
				(gEgo get: 31)
				((ScriptID 21 0) doit: 800)
				((ScriptID 22 0) doit: 16)
				(grapes dispose:)
				(self dispose:)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance inSmellingSalts of Inset
	(properties
		view 526
		loop 1
		x 121
		y 41
		disposeNotOnMe 1
		noun 14
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13
				(proc0_8 0)
				(global2 newRoom: 520)
			)
			(4
				(gGame points: 1 166)
				(gEgo get: 13)
				((ScriptID 21 0) doit: 782)
				(self dispose:)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance inFeAnkle of Inset
	(properties
		view 526
		loop 2
		x 117
		y 133
		disposeNotOnMe 1
		noun 16
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13
				(proc0_8 0)
				(global2 newRoom: 520)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance inIntercom of Inset
	(properties
		view 520
		x 162
		y 79
		disposeNotOnMe 1
		noun 13
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13
				(proc0_8 0)
				(global2 newRoom: 520)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance wrapMusic of WrapMusic
	(properties)
	
	(method (init)
		(= wrapSound wrapSong)
		(super init: &rest)
	)
)

(instance wrapSong of Sound
	(properties)
)

(instance sFX of Sound
	(properties
		flags $0001
	)
)

(instance exitDoVerbCode of Code
	(properties)
	
	(method (doit param1 param2)
		(if (== param1 13)
			(proc0_8 0)
			(global2 newRoom: 520)
		else
			(proc0_6 param2 param1)
		)
	)
)
